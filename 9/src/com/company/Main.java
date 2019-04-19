package com.company;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    private static void partOne(int index) {
        BehaviorSubject<Integer> a = BehaviorSubject.create();
        BehaviorSubject<Integer> b = BehaviorSubject.create();
        if (index == 1)
        {
            Observable<Integer> c = Observable.combineLatest(a, b, (i1, i2) -> i1 + i2);
            c.subscribe(System.out::println);
            a.onNext(10);
            b.onNext(10);
            a.onNext(20);
        }
        else if (index == 2) {
            Observable<Integer> c = a.filter(i -> i % 2 == 0).map(i -> i * i);
            c.subscribe(System.out::println);
            a.onNext(1);
            a.onNext(2);
            a.onNext(3);
            a.onNext(4);
        }
    }

    private static void partTwo(int index) {
        if (index == 1) {
            try {
                URL url = new URL("https://example.com");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                System.out.println(connection.getResponseCode());
                System.out.println(connection.getResponseMessage());

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer response = new StringBuffer();
                String inputLine;
                while ((inputLine = reader.readLine()) != null)
                    response.append(inputLine).append("\n");
                reader.close();

                System.out.println(response);
            } catch (IOException e) {
                System.out.println(e.getStackTrace().toString());
            }
        } else if (index == 2) {

        }

    }

    public static void main(String[] args) {
//        partOne(1);
        partTwo(2);

    }
}
