"use strict";

$(document).ready(() => {

    $("#registerbtn").click(() => {

        let path = "http://localhost:8080/infiniteUser/";
        let user_name = $("#username").val();
        let user_password = $("#password").val();
        let re_password = $("#reenter_password").val();
        let user_role = $("#userrole").val();

        if (user_name == "" || user_password == "" || user_role == "" || re_password == "") {
            alert("Please fill all the fields");
        }
        else {
            if (user_password != re_password) {
                alert("Passwords don't match");
            }

            else {

                let data = { username: user_name, password: user_password, userrole: user_role };

                fetch(path, {
                    headers: {
                        "content-type": "application/json; charset=UTF-8"
                    },
                    method: "POST",
                    body: JSON.stringify(data)
                }
                );

                console.log(JSON.stringify(data))

                alert("User registered successfully")

                window.location.href = "login.html";

            }
        }



    });

    const getJson = (url) => {


        const result = fetch(url)
            .then(response => response.json())
            .catch(e => console.log(e.message));
        return result;
    }


    $("#loginbtn").click(() => {

        const path = "http://localhost:8080/infiniteUser/login";


        let user_name = $("#username").val();
        let user_password = $("#password").val();

        if (user_name == "" || user_password == "") {
            alert("Please fill all the fields");
        }
        else{

            const request = "?username=" + user_name + "&password=" + user_password;

            const url = path + request;
            const json = getJson(url);
    
            const aa = json.then((data) => {
    
                const userroleid = Object(data).userrole;
    
                const userRole = getUserRole(userroleid);
    
                userRole.then((role) => {
    
                    const userRoleVal = Object(role).userrole;
    
                    if (userRoleVal == "employee") {
                        window.location.href = "employee.html";
                    }
                    else if (userRoleVal == "user") {
                        window.location.href = "user.html";
                    }
                });
    
    
            });
        }

    });

    const getUserRole = (userroleid) => {
        const url = "http://localhost:8080/infiniteUserRole/" + userroleid;

        const result = fetch(url)
            .then(response => response.json())
            .catch(e => console.log(e.message));
        return result;

    }

});