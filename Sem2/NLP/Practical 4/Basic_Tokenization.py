import nltk

nltk.download('punkt')

from nltk.tokenize import word_tokenize

text = "Hello! This is a simple NLP tokenization example."

tokens = word_tokenize(text)

print("Word Tokens:", tokens)
