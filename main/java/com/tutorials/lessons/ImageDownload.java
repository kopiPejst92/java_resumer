package com.tutorials.lessons;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageDownload {
    private final String imgPrefix="target/generated-sources/images/";
    public void copyToImgOld() throws IOException {
        String img="https://www.gazetakongresy.pl/wp-content/uploads/2022/09/historia-marki-hoffland-polskiej-projektantki-barbary-hoff-525196-GALLERY_BIG.jpg";
        InputStream imgStream=new URL(img).openStream();
        Files.copy(imgStream, Path.of("lesson12_02.jpg"));
//        in.transferTo(Files.newOutputStream(Path.of("b.jpg")));
    }

    public void httpRequest() throws IOException, InterruptedException {
        String citroneImgUrl="https://images.unsplash.com/photo-1494253109108-2e30c049369b?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8cmFuZG9tfGVufDB8fDB8fHww";
        URI uri= URI.create(citroneImgUrl);

        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder(uri).build();

        HttpResponse<byte[]> response=client.send(request, HttpResponse.BodyHandlers.ofByteArray());
        if(response.statusCode()==200){
            Files.write(Path.of(imgPrefix + "lesson12_03.jpg"), response.body());
        }else {
            System.out.println("There seems to be problem. Status of request: " + response.statusCode() );
        }
    }

}
