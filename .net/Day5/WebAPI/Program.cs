using Microsoft.EntityFrameworkCore;
using StudentAPI.Models;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddControllers();

// Register DbContext
builder.Services.AddDbContext<AssignmentContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("AssignmentContext")));

builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();
app.UseAuthorization();
app.MapControllers();

app.Run();
