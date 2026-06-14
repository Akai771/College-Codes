import nltk
from nltk.corpus import gutenberg

print(gutenberg.fileids())

text = gutenberg.raw('austen-emma.txt')
print(text[:500])

from urllib.request import urlopen

url = "https://www.gutenberg.org/cache/epub/2554/pg2554.txt"
raw = urlopen(url).read()
print(raw)


fread=open("C:\\Users\\admin\\Downloads\\hello.txt")
print(fread.read())
