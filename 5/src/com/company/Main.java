package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.*;

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
        /*Room room = new Room(100);
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
        }*/

        try {

            File sourceFile = new File("result.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(sourceFile);


            // xml reading
            NodeList rootNodes = document.getElementsByTagName("Room");
            Element rootElement = (Element)rootNodes.item(0);
            Room room = new Room( Double.valueOf(rootElement.getAttribute("maxPower")));

            NodeList devices = rootElement.getChildNodes();
            for(int i = 0 ; i < devices.getLength(); ++i) {
                if (devices.item(i) instanceof Element) {
                    Element currentElement = (Element)devices.item(i);

                    Electrical electrical;
                    if (currentElement.getTagName().equals("TV")) {
                        room.getDevices().add(electrical = new TV());
                    } else if (currentElement.getTagName().equals("Teapod")) {
                        room.getDevices().add(electrical = new Teapod());
                    } else {
                        room.getDevices().add(electrical = new Fridge());
                    }

                    electrical.setAmperage( Double.valueOf(currentElement.getAttribute("amperage")));
                    electrical.setVoltage( Double.valueOf(currentElement.getAttribute("voltage")));

                }
            }

            Gson gson = new Gson();
            String stringObject = gson.toJson(room);
            System.out.println(stringObject);


            room.turnOnAll();
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
