let usernameSorted = false;
let fullNameSorted = false;
let departmentNameSorted = false;

function sortByAccountUsername() {
    accountPageNumber = 1;
    usernameSorted = true;
    fullNameSorted = false;
    departmentNameSorted = false;
    let sort_order = $('#username_order').val();
    if (sort_order == "asc") {
        document.getElementById("username_order").value = "desc";
        $('#th-username .fa-sort').css('display', 'none');
        $('#th-username .fa-sort-up').css('display', 'none');
        $('#th-username .fa-sort-down').css('display', 'inline');

        let apiLink = "http://localhost:8080/api/v1/accounts?sort=username,desc";

        let name = $("#search-account-input").val();
        if (name != "") {
            apiLink = apiLink + "&search=" + name;
        }
        let role = document.getElementById('filter-role-select').value;
        let departmentName = document.getElementById('filter-department-select').value;
        if (role != "" && departmentName == "") {
            apiLink = apiLink + "&role=" + role;
        } else if (role == "" && departmentName != "") {
            apiLink = apiLink + "&departmentName=" + departmentName;
        } else if (role != "" && departmentName != "") {
            apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
        }

        buildAccountTable(apiLink);
    }
    if (sort_order == "desc") {
        document.getElementById("username_order").value = "asc";
        $('#th-username .fa-sort').css('display', 'none');
        $('#th-username .fa-sort-up').css('display', 'inline');
        $('#th-username .fa-sort-down').css('display', 'none');

        let apiLink = "http://localhost:8080/api/v1/accounts?sort=username,asc";

        let name = $("#search-account-input").val();
        if (name != "") {
            apiLink = apiLink + "&search=" + name;
        }
        let role = document.getElementById('filter-role-select').value;
        let departmentName = document.getElementById('filter-department-select').value;
        if (role != "" && departmentName == "") {
            apiLink = apiLink + "&role=" + role;
        } else if (role == "" && departmentName != "") {
            apiLink = apiLink + "&departmentName=" + departmentName;
        } else if (role != "" && departmentName != "") {
            apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
        }

        buildAccountTable(apiLink);
    }

    $(
        '#th-full-name .fa-sort-up, #th-full-name .fa-sort-down, ' +
        '#th-department .fa-sort-up, #th-department .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-full-name .fa-sort, #th-department .fa-sort'
    ).css('display', 'inline');

    $('#th-username a, #th-username i').css('color', '#fe6100');
    $('#th-full-name a, #th-full-name i').css('color', '#000');
    $('#th-department a, #th-department i').css('color', '#000');

}

function sortByAccountFullName() {
    accountPageNumber = 1;
    usernameSorted = false;
    fullNameSorted = true;
    departmentNameSorted = false;
    let sort_order = $('#fullName_order').val();
    if (sort_order == "asc") {
        document.getElementById("fullName_order").value = "desc";
        $('#th-full-name .fa-sort').css('display', 'none');
        $('#th-full-name .fa-sort-up').css('display', 'none');
        $('#th-full-name .fa-sort-down').css('display', 'inline');

        let apiLink = "http://localhost:8080/api/v1/accounts?sort=fullName,desc";

        let name = $("#search-account-input").val();
        if (name != "") {
            apiLink = apiLink + "&search=" + name;
        }
        let role = document.getElementById('filter-role-select').value;
        let departmentName = document.getElementById('filter-department-select').value;
        if (role != "" && departmentName == "") {
            apiLink = apiLink + "&role=" + role;
        } else if (role == "" && departmentName != "") {
            apiLink = apiLink + "&departmentName=" + departmentName;
        } else if (role != "" && departmentName != "") {
            apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
        }

        buildAccountTable(apiLink);
    }
    if (sort_order == "desc") {
        document.getElementById("fullName_order").value = "asc";
        $('#th-full-name .fa-sort').css('display', 'none');
        $('#th-full-name .fa-sort-up').css('display', 'inline');
        $('#th-full-name .fa-sort-down').css('display', 'none');

        let apiLink = "http://localhost:8080/api/v1/accounts?sort=fullName,asc";

        let name = $("#search-account-input").val();
        if (name != "") {
            apiLink = apiLink + "&search=" + name;
        }
        let role = document.getElementById('filter-role-select').value;
        let departmentName = document.getElementById('filter-department-select').value;
        if (role != "" && departmentName == "") {
            apiLink = apiLink + "&role=" + role;
        } else if (role == "" && departmentName != "") {
            apiLink = apiLink + "&departmentName=" + departmentName;
        } else if (role != "" && departmentName != "") {
            apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
        }

        buildAccountTable(apiLink);
    }

    $(
        '#th-username .fa-sort-up, #th-username .fa-sort-down, ' +
        '#th-department .fa-sort-up, #th-department .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-username .fa-sort, #th-department .fa-sort'
    ).css('display', 'inline');

    $('#th-username a, #th-username i').css('color', '#000');
    $('#th-full-name a, #th-full-name i').css('color', '#fe6100');
    $('#th-department a, #th-department i').css('color', '#000');

}

function sortByDepartment() {
    accountPageNumber = 1;
    usernameSorted = false;
    fullNameSorted = false;
    departmentNameSorted = true;
    let sort_order = $('#department_order').val();
    if (sort_order == "asc") {
        document.getElementById("department_order").value = "desc";
        $('#th-department .fa-sort').css('display', 'none');
        $('#th-department .fa-sort-up').css('display', 'none');
        $('#th-department .fa-sort-down').css('display', 'inline');

        let apiLink = "http://localhost:8080/api/v1/accounts?sort=departmentName,desc";

        let name = $("#search-account-input").val();
        if (name != "") {
            apiLink = apiLink + "&search=" + name;
        }
        let role = document.getElementById('filter-role-select').value;
        let departmentName = document.getElementById('filter-department-select').value;
        if (role != "" && departmentName == "") {
            apiLink = apiLink + "&role=" + role;
        } else if (role == "" && departmentName != "") {
            apiLink = apiLink + "&departmentName=" + departmentName;
        } else if (role != "" && departmentName != "") {
            apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
        }

        buildAccountTable(apiLink);
    }
    if (sort_order == "desc") {
        document.getElementById("department_order").value = "asc";
        $('#th-department .fa-sort').css('display', 'none');
        $('#th-department .fa-sort-up').css('display', 'inline');
        $('#th-department .fa-sort-down').css('display', 'none');

        let apiLink = "http://localhost:8080/api/v1/accounts?sort=departmentName,asc";

        let name = $("#search-account-input").val();
        if (name != "") {
            apiLink = apiLink + "&search=" + name;
        }
        let role = document.getElementById('filter-role-select').value;
        let departmentName = document.getElementById('filter-department-select').value;
        if (role != "" && departmentName == "") {
            apiLink = apiLink + "&role=" + role;
        } else if (role == "" && departmentName != "") {
            apiLink = apiLink + "&departmentName=" + departmentName;
        } else if (role != "" && departmentName != "") {
            apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
        }

        buildAccountTable(apiLink);
    }

    $(
        '#th-username .fa-sort-up, #th-username .fa-sort-down, ' +
        '#th-full-name .fa-sort-up, #th-full-name .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-username .fa-sort, #th-full-name .fa-sort'
    ).css('display', 'inline');

    $('#th-username a, #th-username i').css('color', '#000');
    $('#th-full-name a, #th-full-name i').css('color', '#000');
    $('#th-department a, #th-department i').css('color', '#fe6100');

}