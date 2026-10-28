import re

# convert text to lower case 
prompt_lower = "  Hello Our NAME is Rajeshri ,Ashwini!  "
str1 = prompt_lower.lower()
print(str1)



# remove basic punctuation 
text = "Hello!!  Riya Ye...diiii AAhe...,,"
punctuation = ",.!?"  
for char in punctuation:
    text = text.replace(char, "")
print(text)
 

# Remove extra spaces
str3 = "  Rajeshri    kalwale   "
space_remove = " ".join(str3.split())
print(space_remove)


# # Tokenization
tokens = space_remove.split()

unique_tokens = set(tokens)

print("All Tokens:", tokens)

print("Unique Tokens:", unique_tokens)

print("Unique Token Count:", len(unique_tokens))

# Tokenization
tokens = text.split()

unique_tokens = set(tokens)

print("All Tokens:", tokens)

print("Unique Tokens:", unique_tokens)

print("Unique Token Count:", len(unique_tokens))


# Tokenization
tokens = text.split()

unique_tokens = set(tokens)

print("All Tokens:", tokens)

print("Unique Tokens:", unique_tokens)

print("Unique Token Count:", len(unique_tokens))






