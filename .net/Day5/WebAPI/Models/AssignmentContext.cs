using Microsoft.EntityFrameworkCore;

namespace StudentAPI.Models
{
    public class AssignmentContext : DbContext
    {
        public AssignmentContext(DbContextOptions<AssignmentContext> options) : base(options) { }

        public DbSet<Student> Students { get; set; }
    }
}
