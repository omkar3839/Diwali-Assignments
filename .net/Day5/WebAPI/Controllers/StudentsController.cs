using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using StudentAPI.Models;

namespace StudentAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentsController : ControllerBase
    {
        private readonly AssignmentContext _context;

        public StudentsController(AssignmentContext context)
        {
            _context = context;
        }

        // a. Display all students
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Student>>> GetAllStudents()
        {
            return await _context.Students.ToListAsync();
        }

        // b. Display student with a particular id
        [HttpGet("{id}")]
        public async Task<ActionResult<Student>> GetStudentById(int id)
        {
            var student = await _context.Students.FindAsync(id);
            if (student == null)
                return NotFound();
            return student;
        }

        // c. Display students with marks in the given range
        [HttpGet("marks")]
        public async Task<ActionResult<IEnumerable<Student>>> GetStudentsByMarks(decimal min, decimal max)
        {
            var students = await _context.Students
                .Where(s => s.Percentage >= min && s.Percentage <= max)
                .ToListAsync();
            return students;
        }
    }
}
