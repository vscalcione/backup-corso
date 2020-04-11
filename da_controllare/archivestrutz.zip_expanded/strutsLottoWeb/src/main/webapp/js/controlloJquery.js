function controllo(values) {
	ok = true;
	$.each(values, function(key, val) {
		if (validator(this)) {
			ok = false;
			return false;
		}
	});
	return ok;
}

function doppi(values) {
	for (var i = 0; i < values.length; i++) {
		
		for (var j = i + 1; j < values.length; j++) {

			if (values[i] == values[j]) {
				return false;
			}
		}
	}
	return true;

}