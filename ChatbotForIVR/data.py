import pandas as pd


df = pd.read_csv('datasetStudents.csv')


# print(df.head())

# print(" Shape ")
# print(df.shape)

# print("Columns ")
# print(df.columns)

# print(" Info ")
# df.info()

# print("Describe")
# print(df.describe())

# print("Specific Column ")
# print(df["Name"])

# print(" Multiple Columns ")
# print(df[["Name", "UnitTest_1_Marks"]])

# Rows with missing values
df_cleaned = df.dropna()

#Print the total count on a fresh line
print("Total remaining rows after dropna:", len(df_cleaned))

# Remove missing values (rows with NaN)
# df = df.dropna()