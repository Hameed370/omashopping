<script>
$(function() {
	$('#myTable')
			.DataTable(
					{
						ajax : {
							url : '/omashoppingfront/admin/allCategories',
							dataSrc : ''
						},
						columns : [
								{
									data : 'id'
								},
								{
									data : 'name'
								},
								{
									data : 'description'
								},

								{
									data : null,
									mRender : function(data, type, row) {
										return '<img src="/omashoppingfront/resources/images/'+ row.id + '.png" height="50" width="50">';
									}
								},
								{
									data : null,
									mRender : function(data, type, row) {
										return '<a class="btn btn-primary" href="/omashoppingfront/admin/showCategory/'
												+ data.id
												+ '">Update Item</a> &nbsp;<a class="btn btn-primary" href="/omashoppingfront/admin/delete/'
												+ data.id
												+ '">Delete</a>';
									}
								} ]
					});

});
</script>


<form:form method="POST" modelAttribute="category"
	action="${contextRoot}/admin/addcategory" class="form-horizontal"
	enctype="multipart/form-data">

	<div class="row">
		<label class="col-md-3" for="id"> Category id</label>
		<div class="col-md-7">
			<form:input path="id" id="id" type="text" />
			<div class="has-error">
				<form:errors path="id" class="help-inline"></form:errors>
			</div>
		</div>

	</div>



	<div class="row">
		<label class="col-md-3" for="name"> Category Name</label>
		<div class="col-md-7">
			<form:input path="name" id="name" type="text" />
			<div class="has-error">
				<form:errors path="name" class="help-inline"></form:errors>
			</div>
		</div>

	</div>

	<div class="row">
		<label class="col-md-3" for="description"> Category
			Description</label>
		<div class="col-md-7">
			<form:input path="description" id="description" type="text" />
			<div class="has-error">
				<form:errors path="description" class="help-inline"/>
			</div>
		</div>

	</div>

	<div class="row">
		<label class="col-md-3" for="imageurl"> Image</label>
		<div class="col-md-7">
			<form:input path="imageurl" id="imageurl" type="text" />
			<div class="has-error">
				<form:errors path="imageurl" class="help-inline"></form:errors>
			</div>
		</div>

	</div>
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="file">Upload a
				file</label>
			<div class="col-md-7">
				<form:input type="file" path="files" id="file"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="files" class="help-inline" />
				</div>
			</div>
		</div>
	</div>

	<div>
		<input type="submit" value="Submit">
	</div>


	 	
		 <div style="color: red">${error}</div>
</form:form>


<div class="row">
	<div class="col-md-offset-2 col-md-8">
		<table class="table table-striped table-bordered" id="myTable">
			<thead>
				<tr>
					<th>id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Image</th>
					<th></th>
				</tr>
			</thead>




		</table>
	</div>
</div>

