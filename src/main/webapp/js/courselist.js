console.log("courselist.html")
var api = "webapi/course/getCourses";
$.get(api, function (course, status) {
    var username = sessionStorage.getItem("username");
    if (status == "success") {

        var course_data_body = "";
        for (var i=0; i<course.length; i++) {
            if(course[i].faculty.username == username) {
                course_data_body += '<tr>'
                    + '<td><a href="/academic_erp_war/studentlist.html" onclick="saveCourseId()" id="courseId" style="color: white">' + course[i].courseId + '</a></td>'
                    + '<td><a href="/academic_erp_war/studentlist.html" onclick="saveCourseId()" id="courseName" style="color: white">' + course[i].courseName + '</a></td>'
                    + '</tr>';
            }
        }

        $('#course_data tbody').html(course_data_body);
    }
    $('#course_data').DataTable();
});

function saveCourseId() {
    sessionStorage.setItem("courseId", document.getElementById("courseId").text);
}