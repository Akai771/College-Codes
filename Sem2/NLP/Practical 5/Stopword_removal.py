import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize

nltk.download('punkt_tab')
nltk.download('punkt')
nltk.download('stopwords')

stop_words = set(stopwords.words('english'))

def remove_stopwords(text):
    word_tokens = word_tokenize(text)
    filtered_list = [w for w in word_tokens if w.lower() not in stop_words]
    return " ".join(filtered_list)

example_text = "I am a good boy and I love running."
result = remove_stopwords(example_text)

print(f"Original: {example_text}")
print(f"Filtered: {result}")

