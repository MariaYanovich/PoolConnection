<!DOCTYPE html>
<html lang="en">
<head>
    <title>Contact</title>
    <meta charset="utf-8">

    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/bootstrap4/bootstrap.min.css">
    <link href="${root}/resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/contact.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/contact_responsive.css">
	<link rel="stylesheet" type="text/css"
		  href="${root}/resources/css/mainPage.css">

</head>
<body>

<div class="super_container">

	<c:import url="/WEB-INF/view/header.jsp" />

    <!-- Home -->

    <div class="home">

			<!-- Contact -->

			<div class="contact">
				<div class="container">
					<div class="row">

						<!-- Get in touch -->
						<div class="col-lg-6">
							<div class="contact_content">
								<div class="contact_title">Get in touch with us.</div>
								<div class="contact_text">
									<p>Pellentesque sit amet elementum ccumsan sit amet
										mattis eget, tristique at leo. Vivamus
										massa.Tempor massa et laoreet. Pellentesque sit
										amet elementum ccumsan sit amet mattis eget,
										tristique at leo. Vivamus massa.</p>
								</div>
								<div class="contact_list">
									<ul>
										<li>
											<div>address:</div>
											<div>1481 Creekside Lane Avila Beach, CA
												931
											</div>
										</li>
										<li>
											<div>phone:</div>
											<div>+53 345 7953 32453</div>
										</li>
										<li>
											<div>email:</div>
											<div>yourmail@gmail.com</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
        </div>
    </div>




<div class="pre-footer">
    <!-- Footer -->
	<div class="parallax_background parallax-window" data-parallax="scroll"
		 data-image-src="${root}/resources/img/footer_1.jpg"
		 data-speed="0.8"></div>
	<div class="container">

		<div class="row footer_contact_row">
			<div class="col-xl-10 offset-xl-1">
				<div class="row">

					<!-- Footer Contact Item -->
					<div class="col-xl-4 footer_contact_col">
						<div class="footer_contact_item d-flex flex-column align-items-center justify-content-start text-center">
							<div class="footer_contact_icon"><img
									src="${root}/resources/img/sign.svg"
									alt=""></div>
							<div class="footer_contact_title">give us a
								call
							</div>
							<div class="footer_contact_list">
								<ul>
									<li>Office Landline: +44 5567 32 664
										567
									</li>
									<li>Mobile: +44 5567 89 3322 332</li>
								</ul>
							</div>
						</div>
					</div>

					<!-- Footer Contact Item -->
					<div class="col-xl-4 footer_contact_col">
						<div class="footer_contact_item d-flex flex-column align-items-center justify-content-start text-center">
							<div class="footer_contact_icon"><img
									src="${root}/resources/img/trekking.svg"
									alt=""></div>
							<div class="footer_contact_title">come & drop
								by
							</div>
							<div class="footer_contact_list">
								<ul style="max-width:190px">
									<li>4124 Barnes Street, Sanford, FL
										32771
									</li>
								</ul>
							</div>
						</div>
					</div>

					<!-- Footer Contact Item -->
					<div class="col-xl-4 footer_contact_col">
						<div class="footer_contact_item d-flex flex-column align-items-center justify-content-start text-center">
							<div class="footer_contact_icon"><img
									src="${root}/resources/img/around.svg"
									alt=""></div>
							<div class="footer_contact_title">send us a
								message
							</div>
							<div class="footer_contact_list">
								<ul>
									<li>youremail@gmail.com</li>
									<li>Office@yourbusinessname.com</li>
								</ul>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
</div>
	<footer>
		<div class="copyrights wrapper">
			Copyright © 2020
			All Rights Reserved.
		</div>
	</footer>
</div>

<script src="${root}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${root}/resources/css/bootstrap4/popper.js"></script>
<script src="${root}/resources/css/bootstrap4/bootstrap.min.js"></script>
<script src="${root}/resources/plugins/easing/easing.js"></script>
<script src="${root}/resources/plugins/parallax-js-master/parallax.min.js"></script>
<script src="${root}/resources/js/contact.js"></script>
</body>
</html>