import nltk

from nltk.stem import PorterStemmer
from nltk.stem import SnowballStemmer
from nltk.stem import LancasterStemmer

stemmer = PorterStemmer()
snowStemmer = SnowballStemmer('english')
lancasterStemmer = LancasterStemmer()

words = ["Happily", "Linked", "talking", "studies", "running", "fasting", "thought", "wolves", "flying", "fairly"]
print("******Using PrterStemmer******")
for word in words:
    print(word, "->", stemmer.stem(word))

    
print("******Using SnowballStemmer******")
for word in words:
    print(word, "->", snowStemmer.stem(word))

    
print("******Using LancasterStemmer******")
for word in words:
    print(word, "->", lancasterStemmer.stem(word))
