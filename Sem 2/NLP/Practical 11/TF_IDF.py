# Practical 11.2 - Aim: text representation using TF-ID

from sklearn.feature_extraction.text import TfidfVectorizer

# sample documents
documents = [
    "i love nlp",
    "i love ai",
    "nlp is fun"
]

# create TF-IDF model
vectorizer = TfidfVectorizer()

# fit and transform data
tfid_matrix = vectorizer.fit_transform(documents)

#get feature names (words)
words = vectorizer.get_feature_names_out()

# print vocabulary
print("Vocabulary:", words)

# print TF-IDF matrix
print("\nTF-IDF Matrix:\n")
print(tfid_matrix.toarray())
