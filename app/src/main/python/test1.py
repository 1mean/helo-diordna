import requests
from lxml import etree

def parse():
    html = requests.get("https://b23.tv/H3f8p5y")
    tree = etree.HTML(html.text)
    title = tree.xpath("//h1[@class='video-title tit']/text()")[0]
    time = tree.xpath("//meta[@itemprop='datePublished']/@content")[0]
    url = tree.xpath("//meta[@itemprop='url']/@content")[0]
    author = tree.xpath("//meta[@itemprop='author']/@content")[0]
    image = tree.xpath("//meta[@itemprop='image']/@content")[0]
    description = tree.xpath("//meta[@itemprop='description']/@content")[0]
    duration = tree.xpath("//div[@class='bilibili-player-video-inner']")
    up=tree.xpath("//div[@class='name']/a/@href")[0]
    list = str(up).split("/")
    code = list[len(list)-1]
    return image