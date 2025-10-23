using Microsoft.EntityFrameworkCore;
using StudentManagement.Models;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddControllersWithViews();

builder.Services.AddDbContext<AssignmentContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("AssignmentContext")));

var app = builder.Build();

app.UseStaticFiles();
app.UseRouting();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Students}/{action=Index}/{id?}");

app.Run();
