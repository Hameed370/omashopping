<!--  
<script>
$(function() {
	$('#myPTable')
			.DataTable(
					{
						ajax : {
							url : '/omashoppingfront/product/allproduct',
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
										return '<a class="btn btn-primary" href="/omashoppingfront/admin/product/showCategory/'
												+ data.id
												+ '">Update Item</a> &nbsp;<a class="btn btn-primary" href="/omashoppingfront/admin/product/delete/'
												+ data.id
												+ '">Delete</a>';
									}
								} ]
					});

});
</script>
-->
<script>
$(function(){
	
	$('#myPTable').DataTable( {
		ajax: {
	        url: '/omashoppingfront/admin/product/allproduct',
	        dataSrc: ''
	    },
	    columns : [
			{
				data : 'id'
			},
			{
				data : 'pname'
			},
			{
				data : 'description'
			},
			{
				data: 'price'},

				{data:'qty'},
				{
				data : null,
				mRender : function(data, type, row) {
					return '<img src="/omashoppingfront/resources/images/'+ row.id + '.jpg" height="50" width="50">';
				}
			},
			{
				data:'active'
				},	
			{
				data : null,
				mRender : function(data, type, row) {
					return '<a class="btn btn-primary" href="/omashoppingfront/admin/product/showProduct/'+ data.id+ '">Update</a> &nbsp; <a class="btn btn-primary" href="/omashoppingfront/admin/product/delete/'
							+ data.id
							+ '">Delete</a>';
				}
			} ]
	} );
	
	
	
});



</script>

<div class="col-sm-offset-1">
<form:form method="POST" modelAttribute="product" action="${contextRoot}/admin/product/addproduct" class="form-horizontal"
	enctype="multipart/form-data">

	<div class="row">
		<label class="col-md-3" for="id"> Product id</label>
		<div class="col-md-7">
			<form:input path="id" id="id" type="text" />
			<div class="has-error">
				<form:errors path="id" class="help-inline"></form:errors>
			</div>
		</div>

	</div>

	<div class="row">
		<label class="col-md-3" for="pname">Product Name</label>
		<div class="col-md-7">
			<form:input path="pname" id="pname" type="text" />
			<div class="has-error">
				<form:errors path="pname" class="help-inline"></form:errors>
			</div>
		</div>

	</div>

	<div class="row">
		<label class="col-md-3" for="description"> Product Description</label>
		<div class="col-md-7">
			<form:input path="description" id="description" type="text" />
			<div class="has-error">
				<form:errors path="description" class="help-inline"/>
			</div>
		</div>

	</div>

	<div class="row">
		<label class="col-md-3" for="price"> Price</label>
		<div class="col-md-7">
			<form:input path="price" id="price" type="text" />
			<div class="has-error">
				<form:errors path="price" class="help-inline"/>
			</div>
		</div>

	</div>
	<div class="row">
		<label class="col-md-3" for="qty">Qty</label>
		<div class="col-md-7">
			<form:input path="qty" id="qty" type="text" />
			<div class="has-error">
				<form:errors path="qty" class="help-inline"/>
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
		<label class="col-md-3" for="active">Enable</label>
		<div class="col-md-7">
			<form:input path="active" id="active" type="text" />
			<div class="has-error">
				<form:errors path="active" class="help-inline"/>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="file">Upload a file</label>
			<div class="col-md-7">
				<form:input type="file" path="files" id="file"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="files" class="help-inline" />
				</div>
			</div>
		</div>
	</div>

	<div class="col-sm-offset-2">
		<input type="submit" class="btn btn-success" value="Submit">
	</div>

		 <div style="color: red">${error}</div>
</form:form>
</div>
<div class="row">
	<div class="col-sm-offset-1 col-sm-10">
		<table class="table table-striped table-bordered" id="myPTable">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Qty</th>
					<th>Image</th>
					<th>Active</th>
					<th>Action</th>
				</tr>
			</thead>

		</table>
	</div>
</div>
