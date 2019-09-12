package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;

public class Main {

    public static void main(String[] args) {
        Room room = new Room(100);
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();


            // xml creation
            Element root = document.createElement("Room");
            root.setAttribute("maxPower", String.valueOf(room.getMaxPower()) );
            document.appendChild(root);
            for(Electrical electrical : room.getDevices()) {
                Element childElement;
                if (electrical instanceof Teapod) {
                    root.appendChild(childElement = document.createElement("Teapod"));
                } else if (electrical instanceof Fridge) {
                    root.appendChild(childElement = document.createElement("Fridge"));
                } else {
                    root.appendChild(childElement = document.createElement("TV"));
                }
                childElement.setAttribute("amperage", String.valueOf(electrical.getAmperage()) );
                childElement.setAttribute("voltage", String.valueOf(electrical.getVoltage()) );
            }



            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            FileOutputStream writer = new FileOutputStream(new File("result.xml"));
            StreamResult result = new StreamResult(writer);

            transformer.transform(new DOMSource(document), result);
        } catch(Exception e){
            System.out.println("aaaaa");
        }
    }
}
