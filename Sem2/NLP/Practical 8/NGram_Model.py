import nltk

nltk.download('punkt_tab')

from nltk.util import ngrams
from nltk.tokenize import word_tokenize

text = "I Love Natural Language Processing"

tokens = word_tokenize(text)

unigrams = list(ngrams(tokens, 1))
bigrams = list(ngrams(tokens, 2))
trigrams = list(ngrams(tokens, 3))

print("Unigrams:", unigrams)
print("Bigrams:", bigrams)
print("Trigrams:", trigrams)
