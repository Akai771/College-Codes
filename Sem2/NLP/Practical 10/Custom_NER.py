# Aim: Building a custom NER(Named Entity Recognition) system

import re
def custom_ner(text):
    entities = {"PERSON": [], "ORG": [], "GPE": []}     # GPE = Geopolitical Enity

    person_pattern = r'\b[A-Z][a-z]+ [A-Z][a-z]+\b'  # Full names like "Jhon Smith"
    org_pattern = r'\b(Google|Microsoft|OpenAI|Infosys|TCS|IBM|JPMorgan Chase & Co.) \b'
    gpe_pattern = r'\b(India|USA|London|Delhi|New York)\b'
    card_pattern = r'\b\d+\b'

    entities["PERSON"] = re.findall(person_pattern, text)
    entities["ORG"] = re.findall(org_pattern, text)
    entities["GPE"] = re.findall(gpe_pattern, text)
    entities["CARDINAL"] = re.findall(card_pattern, text)
    return entities

# Example text
text = "Arshad Ansari working in JPMorgan Chase & Co. in USA reported a net income of $13.4 billion for the first quarter, exceeding analyst expectations on Wall Street."

# Run custom NER
results = custom_ner(text)

# Print extracted entities
for label, items in results.items():
    print(f"{label}: {items}")

    
