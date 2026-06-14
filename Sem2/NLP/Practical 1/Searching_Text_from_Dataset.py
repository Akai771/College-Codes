import nltk

nltk.download('book')

from nltk.book import *

var='hello world'

print(var)
print(nltk.word_tokenize(var))

print("--------------------------------------")
text1.concordance('monstrous')

print("--------------------------------------")
text2.common_contexts(["monstrous","very"])

print("--------------------------------------")
text2.similar("monstrous")

print("--------------------------------------")
text3.generate()




