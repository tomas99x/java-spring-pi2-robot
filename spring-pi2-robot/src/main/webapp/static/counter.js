$(document).ready(
		function() {

			var incrementPlus;
			var incrementMinus;

			var buttonPlus = $(".cart-qty-plus");
			var buttonMinus = $(".cart-qty-minus");

			var incrementPlus = buttonPlus.click(function() {
				var $n = $(this).parent(
						".container").find(".qty");
				$n.val(Number($n.val()) + 1);
			});

			var incrementMinus = buttonMinus.click(function() {
				var $n = $(this).parent(
						".container").find(".qty");
				var amount = Number($n.val());
				if (amount > 1) {
					$n.val(amount - 1);
				}
			});

		});