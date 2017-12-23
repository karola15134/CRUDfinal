$.get("http://localhost:8080/getUsers", function(data) {

                $.each(data, function(i, user) {

                    $(".data-user-js").append(
                        "<tr><td>" + user.name + "</td>" +
                        "<td>" + user.email + "</td></tr>" );
                });

            });