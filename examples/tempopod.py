import requests
import re
import sys
from random import shuffle

# Install requests: pip install requests
# Use: python tempopod.py 90 https://raw.githubusercontent.com/webreactiva-devs/reto-tempopod/main/feed/webreactiva.xml
# Use: python tempopod.py

selected_tempo = int(sys.argv[1]) if len(sys.argv) > 1 else 30  # Minutos
feed_url = sys.argv[2] if len(sys.argv) > 2 else "https://raw.githubusercontent.com/webreactiva-devs/reto-tempopod/main/feed/webreactiva.xml"

def fetch_feed(url):
    response = requests.get(url)
    return response.text

def parse_episodes(feed_str):
    episodes = []
    item_regex = re.compile(r'<item>(.*?)</item>', re.DOTALL)
    items = item_regex.findall(feed_str)
    for item in items:
        title_match = re.search(r'<title>(.*?)</title>', item)
        duration_match = re.search(r'<itunes:duration>(.*?)</itunes:duration>', item)
        if title_match and duration_match:
            episodes.append({
                'title': title_match.group(1),
                'duration': int(duration_match.group(1))
            })
    return episodes

def select_episodes(episodes, tempo):
    selected = []
    total_time = 0
    shuffle(episodes)
    for episode in episodes:
        if total_time + episode['duration'] <= tempo * 60:
            selected.append(episode['title'])
            total_time += episode['duration']
    return selected

feed_str = fetch_feed(feed_url)
episodes = parse_episodes(feed_str)
selected_episodes = select_episodes(episodes, selected_tempo)
print("Episodios seleccionados:", selected_episodes)
