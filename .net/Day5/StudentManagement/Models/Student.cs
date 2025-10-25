using System;
using System.ComponentModel.DataAnnotations;

namespace StudentManagement.Models
{
    public partial class Student
    {
        [Key]
        public int StudentId { get; set; }

        [Required]
        [StringLength(100)]
        public string Name { get; set; }

        [DataType(DataType.Date)]
        public DateTime BirthDate { get; set; }

        [StringLength(200)]
        public string Address { get; set; }

        [StringLength(100)]
        public string SchoolName { get; set; }

        [Range(0, 100)]
        public decimal Percentage { get; set; }
    }
}
