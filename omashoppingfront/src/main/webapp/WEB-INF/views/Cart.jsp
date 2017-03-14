
<div class="container">
	<div class="row">
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
							</div>
							<div class="col-xs-6">
								<a class="btn btn-primary btn-sm btn-block" href="${contextRoot}/">
									<span class="glyphicon glyphicon-share-alt"></span> Continue shopping
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body">
				
				
				<c:forEach items="${cartitemlist}" var="cartitems">	
			
				<div class="row">
				
						<div class="col-xs-2"><img class="img-responsive" src="${img}/${cartitems.productid}.jpg">
						</div>
						<div class="col-xs-4">
							<h4 class="product-name"><strong>${cartitems.productid}</strong></h4><h4><small></small></h4>
						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right">
								<h6><strong>${cartitems.price} <span class="text-muted">x</span></strong></h6>
							</div>
							<div class="col-xs-4">
								<input type="text" class="form-control input-sm" value="${cartitems.quantity}">
							</div>
							<div class="col-xs-2">
								<button type="button" class="btn btn-link btn-xs">
									<span class="glyphicon glyphicon-trash"> </span>
								</button>
							</div>
						</div>
					</div>
					</c:forEach>
					
				<!-- 	<hr>
					<div class="row">
						<div class="col-xs-2"><img class="img-responsive" src="http://placehold.it/100x70">
						</div>
						<div class="col-xs-4">
							<h4 class="product-name"><strong>Product name</strong></h4><h4><small>Product description</small></h4>
						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right">
								<h6><strong>25.00 <span class="text-muted">x</span></strong></h6>
							</div>
							<div class="col-xs-4">
								<input type="text" class="form-control input-sm" value="1">
							</div>
							<div class="col-xs-2">
								<button type="button" class="btn btn-link btn-xs">
									<span class="glyphicon glyphicon-trash"> </span>
								</button>
							</div>
						</div>
					</div>
				 -->	<hr>
					<div class="row">
						<div class="text-center">
							<div class="col-xs-9">
								<h6 class="text-right">Added items?</h6>
							</div>
							<div class="col-xs-3">
								<button type="button" class="btn btn-default btn-sm btn-block">
									Update cart
								</button>
							</div>
						</div>
					</div>
					
				
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">Total <strong>${cart.grandTotal}</strong></h4>
						</div>
						<div class="col-xs-3">
							<a type="button" href="${contextRoot}/customer/cart/checkout" class="btn btn-success btn-block">
								Checkout
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
	</div>
</div>