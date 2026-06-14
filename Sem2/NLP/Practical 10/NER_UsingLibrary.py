import spacy

nlp = spacy.load("en_core_web_sm")

text = "Nandani is a good person born on wednesday 29 february in mount fuji in tokyo, she bought bun in  ₹500"

doc = nlp(text)

for ent in doc.ents:
    print(ent.text, ent.label_)
