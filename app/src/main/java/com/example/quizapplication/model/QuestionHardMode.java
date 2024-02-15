package com.example.quizapplication.model;

public class QuestionHardMode {

    public static String[] question = {
            "What is the time complexity of a binary search?",
            "What language is primarily used for Android Development?",
            "Which data structure uses LIFO?",
            "What does SQL stand for?",
            "What is the main use of a JWT token?",
            "What does OOP stand for?",
            "Which sort algorithm is typically fastest?",
            "What is the range of short data type in Java?",
            "What does XML stand for?",
            "Which HTTP method is idempotent?"
    };

    public static String[][] choices = {
            {"O(log n)", "O(n log n)", "O(n)", "O(n^2)"},
            {"Java", "Swift", "C#", "JavaScript"},
            {"Queue", "Stack", "Array", "LinkedList"},
            {"Structured Query Language", "Standard Query Language", "Styled Query Language", "Statement Query Language"},
            {"Data Storage", "User Authentication", "Rendering", "Data Encryption"},
            {"Object-Oriented Programming", "Organized Operational Processes", "Optimal Operating Parameters", "Official Opening Protocol"},
            {"Quick Sort", "Bubble Sort", "Insertion Sort", "Selection Sort"},
            {"-32768 to 32767", "-2147483648 to 2147483647", "0 to 65535", "-128 to 127"},
            {"eXecutable Markup Language", "eXtensible Markup Language", "eXtra Markup Language", "eXchange Markup Language"},
            {"GET", "POST", "PUT", "PATCH"}
    };

    public static String[] correctAnswers = {
            "O(log n)",
            "Java",
            "Stack",
            "Structured Query Language",
            "User Authentication",
            "Object-Oriented Programming",
            "Quick Sort",
            "-32768 to 32767",
            "eXtensible Markup Language",
            "GET"
    };
}
