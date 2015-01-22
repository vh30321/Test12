
<%@page import="ejb.GroupTable"%>
<%@page import="java.util.List"%>

    <form role="form" class="form-horizontal">
        <div class="form-body">

     
                <div id="add_client" style="display:none" class="app-alerts alert alert-success fade in">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                    
                </button>User has been saved!</div>
            
               <div id="validation" style="display: none" class="app-alerts alert alert-success fade in">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                    
                </button>All required!</div>
            
            <div class="form-group" id="group_name" >
                <label class="col-md-4 control-label" for="inputSuccess" id="label_name">Name</label>
                <div class="col-md-8">
                    <div class="input-icon right">
                        <input type="text" class="form-control" id="client_name">
                    </div>
                </div>
            </div>
            <div class="form-group" id="group_name" >
                <label class="col-md-4 control-label" for="inputSuccess" id="label_name">Surname</label>
                <div class="col-md-8">
                    <div class="input-icon right">
                        <input type="text" class="form-control" id="client_surname">
                    </div>
                </div>
            </div>
            <div class="form-group" >
                <label class="col-md-4 control-label" for="inputSuccess" id="label_name">Birthday</label>
                <div class="col-md-8">
                   
                        <input type="date" class="form-control" id="client_birthday">
                   
                </div>
            </div>
            <div class="form-group" >
                <label class="col-md-4 control-label" for="inputSuccess" id="label_name">Email</label>
                <div class="col-md-8">
                    <div class="input-icon right">
                        <input type="email" class="form-control" id="client_email">
                    </div>
                </div>
            </div>
               <div class="form-group">
                <label class="col-md-4 control-label" for="inputSuccess" id="label_name">Tel</label>
                <div class="col-md-8">
                    <div class="input-icon right">
                        <input type="number" class="form-control" id="client_number">
                    </div>
                </div>
            </div>

          





        </div>
        <div class="form-actions fluid">
            <div class="col-md-offset-4 col-md-8">

                <button type="button" class="btn blue" id="submit_button">Save</button>
            </div>
        </div>
    </form>
</div>

<script src="incl/Client/addClient.js"></script>

<script src="template/assets/plugins/bootbox/bootbox.min.js"></script>
<script src="template/assets/plugins/bootbox/bootbox.min_1.js"></script>
