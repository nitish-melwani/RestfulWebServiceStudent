$(document).ready(function () {
    $("button#getstudents").click(function () {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:7777/student',
            success: function (studentArray) {
                var studentsTable = $('table#tbl');
                studentsTable.empty();
                $("#tbl").append("<tbody><tr><td>" + "ID" + "</td><td>" + "Name" + "</td><td>" + "Age" + "</td><td>" + "Mobile Number" + "</td><td>" + "Address" + "</td><td>" + "Edit" + "</td><td>" + "" + "</td></tr></tbody>")
                $.each(studentArray, function (index, student) {
                    $("#tbl").append("<tbody><tr><td><div contenteditable>" + student.id + "</div></td><td><div contenteditable>" + student.name + "</div></td><td><div contenteditable>" + student.age + "</div></td><td><div contenteditable>" + student.num + "</div></td><td><div contenteditable>" + student.addr + "</div></td><td>" + "<button class='delete' onclick='studentEdit(this," + student.id + ");'> Edit </button>" + "</td><td>" + "<button class='delete' onclick='studentDelete(this," + student.id + ");'> Delete </button>" + "</td></tr></tbody>")
                    // $("#tbl").append("<tbody><tr><td>"+student.id+"</td><td>"+student.name+"</td><td>"+student.age+"</td><td>"+student.num+"</td><td>"+student.addr+"</td><td>"+"<button class='delete' onclick='studentEdit(this," + student.id + ");'> Edit </button>"+"</td><td>"+"<button class='delete' onclick='studentDelete(this," + student.id + ");'> Delete </button>"+"</td></tr></tbody>")  

                })
            },
            error: function (xhr, status, error) {
                alert("error");
                console.error();
            }

        })
    });
})


function studentDelete(ctl, id) {
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:7777/student/' + id,
        success: function () {
            $(ctl).parents("tr").remove();
        },
        error: function (xhr, status, error) {
            alert("error");
            console.error();
        }
    })
}


function studentEdit(ctl, id) {
    var _row = $(ctl).parents("tr");
    var cols = _row.children("td");


    var student = {
        id: $(cols[0]).text(),
        name:  $(cols[1]).text(),
        age:  $(cols[2]).text(),
        num:  $(cols[3]).text(),
        addr:  $(cols[4]).text()
    }
        $.ajax({
            type: 'PUT',
            contentType: "application/json",
            url: 'http://localhost:7777/student/' + id,
            data: JSON.stringify(student),
            dataType: "json",
            success: function () {
            },
            error: function (xhr, status, error) {
                alert("error");
                console.error();
            }
        })  
}


$(document).ready(function () {
    $("form#getstudentbyid").submit(function (event) {
        event.preventDefault();

        var id = $("#id").val()
        $.ajax({
            type: 'GET',
            url: 'http://localhost:7777/student/' + id,
            success: function (studentArray) {
                var studentsTable = $('table#tbl');
                studentsTable.empty();
                $("#tbl").append("<tbody><tr><td>" + "ID" + "</td><td>" + "Name" + "</td><td>" + "Age" + "</td><td>" + "Mobile Number" + "</td><td>" + "Address" + "</td><td>" + "Edit" + "</td><td>" + "" + "</td></tr></tbody>")

                $.each(studentArray, function (index, student) {
                    $("#tbl").append("<tbody><tr><td>" + student.id + "</td><td>" + student.name + "</td><td>" + student.age + "</td><td>" + student.num + "</td><td>" + student.addr + "</td><td>" + "Edit" + "</td><td>" + "<button class='delete' onclick='studentDelete(this," + student.id + ");'> Delete </button>" + "</td></tr></tbody>")
                })
            },
            error: function() {
                alert('FAILURE!');
            }
        })
    });
})


$(document).ready(function () {
    $("form#getstudentbyname").submit(function (event) {
        event.preventDefault();
        var name = $("#name").val()
        $.ajax({
            type: 'GET',
            url: 'http://localhost:7777/student/name/' + name,
            success: function (studentArray) {
                var studentsTable = $('table#tbl');
                studentsTable.empty();
                $("#tbl").append("<tbody><tr><td>" + "ID" + "</td><td>" + "Name" + "</td><td>" + "Age" + "</td><td>" + "Mobile Number" + "</td><td>" + "Address" + "</td><td>" + "Edit" + "</td><td>" + "" + "</td></tr></tbody>")
                $.each(studentArray, function (index, student) {
                    $("#tbl").append("<tbody><tr><td>" + student.id + "</td><td>" + student.name + "</td><td>" + student.age + "</td><td>" + student.num + "</td><td>" + student.addr + "</td><td>" + "Edit" + "</td><td>" + "<button class='delete' onclick='studentDelete(this," + student.id + ");'> Delete </button>" + "</td></tr></tbody>")
                })
            },
            error: function (xhr, status, error) {
                alert("error");
                console.error();
            }
        })
    });
})


$(document).ready(function () {
    $("form#savestudent").submit(function (event) {
        event.preventDefault();
        var student = {
            id: $("#id").val(),
            name: $("#name").val(),
            age: $("#age").val(),
            num: $("#num").val(),
            addr: $("#addr").val()
        }
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: 'http://localhost:7777/student',
            data: JSON.stringify(student),
            dataType: "json",
            success: function (result) {
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("data", student)
                console.log("ERROR: ", e);
            }
            // encode: true,
        })


    });
});


