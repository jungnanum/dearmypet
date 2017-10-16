var LoginForm = function () {

    return {
        
        //Masking
        initLoginForm: function () {
	        // Validation for login form
	        $("#sky-form1").validate({
	            // Rules for form validation
	            rules:
	            {
	                email:
	                {
	                    required: true,
	                    email: true
	                },
	                password:
	                {
	                    required: true,
	                    minlength: 3,
	                    maxlength: 20
	                }
	            },
	                                
	            // Messages for form validation
	            messages:
	            {
	                email:
	                {
	                    required: '이메일 주소를 입력해주세요',
	                    email: '이메일 주소를 정확하게 입력해주세요'
	                },
	                password:
	                {
	                    required: '비밀번호를 입력해주세요'
	                }
	            },                  
	            
	            // Do not change code below
	            errorPlacement: function(error, element)
	            {
	                error.insertAfter(element.parent());
	            }
	        });
	        
	        // Validation for recovery form
	        $("#sky-form2").validate({
	            // Rules for form validation
	            rules:
	            {
	                email:
	                {
	                    required: true,
	                    email: true
	                },
		            password:
		            {
		                required: true,
		                minlength: 3,
		                maxlength: 20
		            }
	            },
	                                
	            // Messages for form validation
	            messages:
	            {
	                email:
	                {
	                    required: '이메일 주소를 입력해주세요',
	                    email: '이메일 주소를 정확하게 입력해주세요'
	                },
	                password:
	                {
	                    required: '비밀번호를 입력해주세요'
	                }
	            },
	                                
	            // Ajax form submition                  
	            submitHandler: function(form)
	            {
	                $(form).ajaxSubmit(
	                {
	                    success: function()
	                    {
	                        $("#sky-form2").addClass('submited');
	                    }
	                });
	            },              
	            
	            // Do not change code below
	            errorPlacement: function(error, element)
	            {
	                error.insertAfter(element.parent());
	            }
	        });
        }

    };

}();