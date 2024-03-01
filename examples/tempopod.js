// Use: node tempopod.js 45 https://raw.githubusercontent.com/webreactiva-devs/reto-tempopod/main/feed/webreactiva.xml
// Use: node tempopod.js 

const args = process.argv.slice(2);
const selectedTempo = args[0] || 30; // Minutes
const feedUrl =
  args[1] ||
  "https://raw.githubusercontent.com/webreactiva-devs/reto-tempopod/main/feed/webreactiva.xml";

fetch(feedUrl)
  .then((response) => response.text())
  .then((str) => {
    const episodes = [];
    const itemRegex = /<item>(.*?)<\/item>/gs;
    let itemMatch;
    while ((itemMatch = itemRegex.exec(str)) !== null) {
      const episodeContent = itemMatch[1];
      const titleMatch = episodeContent.match(/<title>(.*?)<\/title>/);
      const durationMatch = episodeContent.match(
        /<itunes:duration>(.*?)<\/itunes:duration>/
      );
      if (titleMatch && durationMatch) {
        episodes.push({
          title: titleMatch[1],
          duration: parseInt(durationMatch[1]),
        });
      }
    }
    return selectEpisodes(episodes, selectedTempo);
  })
  .then((selectedEpisodes) =>
    console.log("Episodios seleccionados:", selectedEpisodes)
  )
  .catch((error) => console.error("Error:", error));

function selectEpisodes(episodes, tempo) {
  let selected = [];
  let totalTime = 0;
  episodes = episodes.sort(() => 0.5 - Math.random());

  for (let episode of episodes) {
    if (totalTime + episode.duration <= tempo * 60) {
      selected.push(episode.title);
      totalTime += episode.duration;
    }
  }

  return selected;
}
