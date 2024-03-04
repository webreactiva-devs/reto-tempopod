// Tested :)
// ~/test via ☕ v17.0.10
// ➜ java TempoPod 180

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TempoPod {

    public static void main(String[] args) throws Exception {
        int selectedTempo = args.length > 0 ? Integer.parseInt(args[0]) : 30;
        String feedUrl = args.length > 1 ? args[1] : "https://raw.githubusercontent.com/webreactiva-devs/reto-tempopod/main/feed/webreactiva.xml";

        String xmlContent = fetchFeed(feedUrl);
        List<Episode> episodes = parseEpisodes(xmlContent);
        List<String> selectedEpisodes = selectEpisodes(episodes, selectedTempo);
        System.out.println("Episodios seleccionados:");
        selectedEpisodes.forEach(System.out::println);
    }

    private static String fetchFeed(String feedUrl) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(feedUrl))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private static List<Episode> parseEpisodes(String xmlContent) throws Exception {
        List<Episode> episodes = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlContent)));
        NodeList items = document.getElementsByTagName("item");
        for (int i = 0; i < items.getLength(); i++) {
            Node item = items.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;
                String title = element.getElementsByTagName("title").item(0).getTextContent();
                String durationStr = element.getElementsByTagName("itunes:duration").item(0).getTextContent();
                int duration = Integer.parseInt(durationStr);
                episodes.add(new Episode(title, duration));
            }
        }
        return episodes;
    }

    private static List<String> selectEpisodes(List<Episode> episodes, int tempo) {
        Collections.shuffle(episodes);
        List<String> selected = new ArrayList<>();
        int totalTime = 0;
        for (Episode episode : episodes) {
            if (totalTime + episode.duration <= tempo * 60) {
                selected.add(episode.title);
                totalTime += episode.duration;
            }
        }
        return selected;
    }

    static class Episode {
        String title;
        int duration;

        Episode(String title, int duration) {
            this.title = title;
            this.duration = duration;
        }
    }
}
