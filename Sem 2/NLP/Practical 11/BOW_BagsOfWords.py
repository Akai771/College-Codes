# Practical 11.1 - AIM: Creating and comparing different text representation
from collections import Counter

# sample documents
documents = [
    "i love nlp",
    "i love ai",
    "nlp is fun"
]

# 1. Build vocabulary
vocab = set()

for doc in documents:
    words = doc.split()
    vocab.update(words)

vocab = sorted(vocab)  # fixed order
print("Vocbulary:", vocab)

# 2. Convert each document into BOW(Bag of Words) vector
def bow_vector(doc, vocab):
    words = doc.split()
    word_count = Counter(words)

    return [word_count[word] for word in vocab]

# 3. apply to all documents
vectors = []

for doc in documents:
    vector = bow_vector(doc, vocab)
    vectors.append(vector)

# 4. print result
for doc, vec in zip(documents, vectors):
    print(doc, "->", vec)
