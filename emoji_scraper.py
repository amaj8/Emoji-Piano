import requests
from bs4 import BeautifulSoup as bs

url = 'https://unicode.org/emoji/charts/full-emoji-list.html'
res = requests.get(url)
soup = bs(res.text,'html.parser')
emoji_tags = soup.find_all('td',attrs={'class':"chars"})
with open('emojis.java','w') as f:
    for emoji in emoji_tags:
        f.write(emoji.get_text()+"\n")