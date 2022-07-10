var api = "webapi/course/getCourseStudents";
$.get(api, function (course, status) {
    var courseId = sessionStorage.getItem("courseId");
    var username = sessionStorage.getItem("username");
    console.log(courseId);
    if (status == "success") {
        var student_data_body = "";
            $('#studentGrade').show();
            $('#gradeSubmit').show();
            $('#instruction').show();

            for (var i = 0; i < course.length; i++) {
                if (course[i].course.courseId == courseId) {
                    student_data_body += '<tr>'
                        + '<td>' + course[i].student.studentId+ '</td>'
                        + '<td>' + course[i].student.rollNumber + '</td>'
                        + '<td>' + course[i].student.name + '</td>'
                        + '<td contenteditable="true">' + course[i].grade + '</td>'
                        + '</tr>';
                }
            }
        $('#student_data tbody').html(student_data_body);
    }
    $('#student_data').DataTable();
});


function showTableData() {
    var myTab = document.getElementById('student_data');
    var jsonObj = [];
    var item = {};
    // LOOP THROUGH EACH ROW OF THE TABLE AFTER HEADER.
    for (var i = 1; i < myTab.rows.length; i++) {

        // GET THE CELLS COLLECTION OF THE CURRENT ROW.
        var objCells = myTab.rows.item(i).cells;

        item = {};
        item["course"] = parseInt(sessionStorage.getItem("courseId"));
        for (var j = 0; j < objCells.length; j++) {
            console.log(objCells.item(j).innerHTML);
            if (j==0) item["student"] = parseInt(objCells.item(j).innerHTML);
            if (j==3) item["grade"] = parseInt(objCells.item(j).innerHTML);
        }
        jsonObj.push(item);
    }
    //alert(JSON.stringify(jsonObj));
    var jsonText = JSON.stringify(jsonObj);
    //console.log(jsonText);
    $.post('webapi/faculty/updateGrade', jsonText);
}