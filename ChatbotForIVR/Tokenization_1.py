import string


raw_text = "   Hello Our NAME is Rajeshri ,Ashwini! ... Hello   "

print("1. Original Text:", repr(raw_text))


str_lower = raw_text.lower()
print("2. Lowercase Text:", repr(str_lower))


punctuation = ",.!?"  
str_no_punct = str_lower
for char in punctuation:
    str_no_punct = str_no_punct.replace(char, "")
print("3. Punctuation Removed:", repr(str_no_punct))


final_clean_text = " ".join(str_no_punct.split())
print("4. Final Cleaned Text:", repr(final_clean_text))



tokens = final_clean_text.split()
unique_tokens = set(tokens)

print("\n--- RESULTS ---")
print("Cleaned String:", final_clean_text)
print("Total Token Count:", len(tokens))
print("Unique Token Count:", len(unique_tokens))