
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="shortcut icon" href="favicon_16.ico"/>
    <link rel="bookmark" href="favicon_16.ico"/>
    <!-- site css -->
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/site.css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,800,700,400italic,600italic,700italic,800italic,300italic" rel="stylesheet" type="text/css">
    <!-- <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'> -->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->

    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #303641;
            color: #C1C3C6
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-signin"  role="form" id="loginForm" action="/Login" method="post">
        <h3 class="form-signin-heading">Please sign in</h3>
        <h5>${ResponseMessage}</h5>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">
                    <i class="glyphicon glyphicon-user"></i>
                </div>
                <input type="text" class="form-control" name="username" id="username" placeholder="Username" autocomplete="off" />
            </div>
        </div>

        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">
                    <i class=" glyphicon glyphicon-lock "></i>
                </div>
                <input type="password" class="form-control" name="password" id="password" placeholder="Password" autocomplete="off" />
            </div>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="btnLogin">Sign in</button>
    </form>

</div>
<div class="clearfix"></div>
<br><br>
<!--footer-->
<div class="site-footer login-footer">
    <div class="container">
        <div class="copyright clearfix text-center">
        </div>
    </div>
</div>
<script type="text/javascript" src="/assets/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery-validate.bootstrap-tooltip.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/assets/js/html5shiv.js"></script>
<script type="text/javascript" src="/assets/js/jquery.fs.selecter.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery.fs.stepper.min.js"></script>
<script type="text/javascript" src="/assets/js/icheck.min.js"></script>
<script type="text/javascript" src="/assets/js/respond.min.js"></script>
<script type="text/javascript" src="/assets/js/application.js"></script>
<script type="text/javascript">
    $(function(){

        $('#loginForm').validate({
            rules:{
                username: {required: true},
                password: {required: true}
            },
            messages:{
                username: {required: 'User name is required'},
                password: {password: 'Password is required.'}
            }
        });


    });
</script>
</body>
</html>
