import nltk
nltk.download('wordnet')
from nltk.stem import WordNetLemmatizer
lemmatizer = WordNetLemmatizer()
words = ["Happily", "Linked", "talking", "studies", "running", "fasting", "thought", "wolves", "flying", "fairly"]
print("******Using WordNetLemmatizer******")
for word in words:
    print(word, "->", lemmatizer.lemmatize(word))


import spacy
nlp = spacy.load("en_core_web_sm")
doc = nlp("Apple is looking at buying a startup in India")
print("******Using Spacy Library******")
for word in doc:
    print(word.text, "->", word.lemma_, "->", word.pos_)

