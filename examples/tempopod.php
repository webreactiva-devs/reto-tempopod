<?php

// Use: php tempopod.php 90 https://raw.githubusercontent.com/webreactiva-devs/reto-tempopod/main/feed/webreactiva.xml
// Use: php tempopod.php

$selectedTempo = $argv[1] ?? 30;
$feedUrl = $argv[2] ?? "https://raw.githubusercontent.com/webreactiva-devs/reto-tempopod/main/feed/webreactiva.xml";

$xmlContent = file_get_contents($feedUrl);
$episodes = [];
preg_match_all('/<item>(.*?)<\/item>/s', $xmlContent, $items);

foreach ($items[1] as $item) {
  preg_match('/<title>(.*?)<\/title>/', $item, $titleMatch);
  preg_match('/<itunes:duration>(.*?)<\/itunes:duration>/', $item, $durationMatch);
  if ($titleMatch && $durationMatch) {
    $episodes[] = [
      'title' => $titleMatch[1],
      'duration' => (int) $durationMatch[1],
    ];
  }
}

$selectedEpisodes = selectEpisodes($episodes, $selectedTempo);
echo "Episodios seleccionados:\n";
foreach ($selectedEpisodes as $episode) {
  echo "- " . $episode['title'] . "\n";
}


function selectEpisodes($episodes, $tempo) {
  $selected = [];
  $totalTime = 0;
  shuffle($episodes);

  foreach ($episodes as $episode) {
    if ($totalTime + $episode['duration'] <= $tempo * 60) {
      $selected[] = $episode;
      $totalTime += $episode['duration'];
    }
  }

  return $selected;
}
