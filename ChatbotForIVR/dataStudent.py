import pandas as pd
import numpy as np 


df = pd.read_csv('datasetStudents.csv')


# Open the file and print every line directly to the terminal
# with open('datasetStudents.csv', 'r') as file:
#     for line in file:
#         print(line, end='')

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




# # Create a copy to keep your original data safe
# df_filled = df.copy()

# # Fill missing attendance with the average attendance
# df_filled['Attendance_percentage'] = df_filled['Attendance_percentage'].fillna(df_filled['Attendance_percentage'].mean())

# # Fill missing marks with the average marks for that specific test
# df_filled['UnitTest_1_Marks'] = df_filled['UnitTest_1_Marks'].fillna(df_filled['UnitTest_1_Marks'].mean())
# df_filled['UnitTest_2_Marks'] = df_filled['UnitTest_2_Marks'].fillna(df_filled['UnitTest_2_Marks'].mean())

# print("Updated Data")
# print(df_filled.head(18)) 




# Drops any row where the RollNo has already appeared
df_no_duplicates = df.drop_duplicates(subset=['RollNo'])

print("Original rows:", len(df))
print("Rows after removing duplicates:", len(df_no_duplicates))
print(df_no_duplicates)



# Create a working copy
df_filled = df_no_duplicates.copy()

#  Mark attendance percentages ABOVE 100 as invalid (NaN)
df_filled.loc[df_filled['Attendance_percentage'] > 100, 'Attendance_percentage'] = np.nan

# Fill missing values using the average (mean) of each numeric column
df_filled['Attendance_percentage'] = df_filled['Attendance_percentage'].fillna(df_filled['Attendance_percentage'].mean())
df_filled['UnitTest_1_Marks'] = df_filled['UnitTest_1_Marks'].fillna(df_filled['UnitTest_1_Marks'].mean())
df_filled['UnitTest_2_Marks'] = df_filled['UnitTest_2_Marks'].fillna(df_filled['UnitTest_2_Marks'].mean())

#  Round all decimal values to 1 decimal place
df_filled = df_filled.round(1)

#  Print the final cleaned data to console
import pandas as pd
pd.set_option('display.max_rows', None)

print("Final Cleaned & Populated Dataset")
print(df_filled)