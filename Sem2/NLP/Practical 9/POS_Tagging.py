# practical 9 to implement POS tagging

print("*****************Using nltk*********************")

import nltk

nltk.download('averaged_perceptron_tagger_eng')
nltk.download('punkt')

from nltk.tokenize import word_tokenize
from nltk import pos_tag

text = "The quick brown fox jumps over lazy dog"

tokens = word_tokenize(text)
tags = pos_tag(tokens)

print(tags)



print("*****************Using Spacy*********************")

import spacy
nlp = spacy.load("en_core_web_sm")
doc = nlp("The quick brown fox jumps over lazy dog")

for token in doc:
    print(token.text, token.pos_)



print("*****************Using Treebank*********************")

import nltk
from nltk.tag import hmm
from nltk.corpus import treebank

#download corpus
nltk.download('treebank')

#preparing training data
train_data = treebank.tagged_sents()[:3000]

trainer = hmm.HiddenMarkovModelTrainer()

hmm_tagger = trainer.train_supervised(train_data)

sentence = "The quick brown fox jumps over lazy dog".split()
tags = hmm_tagger.tag(sentence)

print(tags)
