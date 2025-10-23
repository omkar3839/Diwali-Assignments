using System;
using System.Collections;   // ArrayList lives here

namespace ArrayListNamesDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            ArrayList names = new ArrayList();
            const int TOTAL = 10;

            Console.WriteLine("Enter 10 names (press Enter after each):");

            for (int i = 1; i <= TOTAL; i++)
            {
                Console.Write($"Name {i}: ");
                string input = Console.ReadLine();

                // basic validation: require non-empty input
                if (string.IsNullOrWhiteSpace(input))
                {
                    Console.WriteLine("Empty input is not allowed. Please enter a valid name.");
                    i--; // retry same index
                    continue;
                }

                names.Add(input.Trim());
            }

            // Sort the ArrayList (default lexical order)
            names.Sort();

            // Display sorted names
            Console.WriteLine();
            Console.WriteLine("Sorted names:");
            foreach (object o in names)
            {
                // each item is object; cast to string for clarity
                Console.WriteLine((string)o);
            }

            Console.WriteLine();
            Console.WriteLine("Press any key to exit...");
            Console.ReadKey();
        }
    }
}
