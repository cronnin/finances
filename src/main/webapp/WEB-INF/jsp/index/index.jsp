<!--< %@ include file="/header.jsp" %> 

<core-header-panel>

    <core-toolbar>

        <paper-tabs id="tabs" selected="all" self-end>
            <paper-tab name="all">All</paper-tab>
            <paper-tab name="favorites">Favorites</paper-tab>
        </paper-tabs>

    </core-toolbar>

    It works!! ${variable} ${linkTo[IndexController].index}
</core-header-panel>

< %@ include file="/footer.jsp" %> 
-->
<!doctype html>
<html>

    <head>

        <title>unquote</title>

        <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes">

        <script src="polymer/components/platform/platform.js">
        </script>

        <link rel="import" href="polymer/components/font-roboto/roboto.html">
        <link rel="import" href="polymer/components/core-header-panel/core-header-panel.html">
        <link rel="import" href="polymer/components/core-toolbar/core-toolbar.html">
        <link rel="import" href="polymer/components/paper-input-master/paper-input.html">
        <link rel="import" href="polymer/components/paper-button/paper-button.html">
        <link rel="import" href="polymer/components/paper-input-master/paper-password.html">
        <link rel="import" href="polymer/components/paper-tabs/paper-tabs.html">
        <link rel="import" href="polymer/finished/post-list.html">
        

        <style>
            html,body {
                height: 100%;
                margin: 0;
                background-color: #E5E5E5;
                font-family: 'RobotoDraft', sans-serif;
            }
            core-header-panel {
                height: 100%;
                overflow: auto;
                -webkit-overflow-scrolling: touch; 
            }
            core-toolbar {
                background: #03a9f4;
                color: white;
            }
            #tabs {
                width: 100%;
                margin: 0;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
                text-transform: uppercase;
            }
            .container {
                width: 80%;
                margin: 50px auto;
            }
            @media (min-width: 481px) {
                #tabs {
                    width: 200px;
                }
                .container {
                    padding: 10px;
                }
            }
            paper-input,paper-password{
                width: 100%;
            }
            
        </style>

    </head>

    <body unresolved>

    <core-header-panel>

        <core-toolbar>

            <paper-tabs id="tabs" selected="all" self-end>
                <paper-tab name="all">All</paper-tab>
                <paper-tab name="favorites">Favorites</paper-tab>
            </paper-tabs>

        </core-toolbar>

        <div class="container" layout vertical center>
            <paper-input label="Nome:" floatingLabel="true"></paper-input>
            <paper-input label="E-mail:" floatingLabel="true"></paper-input>
            <paper-input label="Login:" floatingLabel="true"></paper-input>
            <paper-password label="Senha:" floatingLabel="true"></paper-password>
            <paper-password label="Verificar Senha:" floatingLabel="true"></paper-password>
            <paper-button label="Enviar" raisedButton="true"></paper-button>
        </div>

    </core-header-panel>
    
    <h1>Collaborative Whiteboard App</h1>
    
    <div id="output"></div>
    <script type="text/javascript" src="js/websocket.js"></script>
</body>

</html>
