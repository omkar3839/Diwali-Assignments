using System;
using System.Linq;

namespace LINQ
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] IntArray = { 12, 5, 24, 10, 9, 8, 4, 87, 23, 7, 11, 43 };


            var below20_query =
                from num in IntArray
                where num < 20
                orderby num
                select num;


            Console.WriteLine("Using query expression:");
            foreach (var n in below20_query)
                Console.Write(n + " ");
            Console.WriteLine();



        }
    }
}
