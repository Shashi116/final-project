export function validObjectCheck(obj) {
  return obj !== undefined && obj !== null && obj !== "" ? true : false;
}
export function validateNumber(event) {
  if (!/[0-9]/.test(event.key)) {
    event.preventDefault();
  }
}
