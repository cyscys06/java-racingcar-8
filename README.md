## Model
### CarModel
- [x] moveCar: 이동 횟수를 증가시키는 기능

## View
### InputView
- [x] getInput: 자동차 이름과 구분자로 구성된 문자열을 입력받는 기능
- [x] getAttemptsCount: 이동 시도 횟수를 입력받는 기능

### OutputView
- [x] requestInput: 사용자에게 자동차 이름 입력 요구 메세지를 출력하는 기능
- [x] requestAttemptsCount: 사용자에게 이동 시도 횟수 입력 요구 메세지를 출력하는 기능
- [ ] 우승자(1명이상)를 출력하는 기능

#### printCarData: 자동차 객체의 정보를 출력하는 기능
- [x] printCarName: 자동차 객체의 이름을 출력하는 기능
- [x] printCarMovementCount: 자동차 객체의 이동 횟수만큼 하이픈('-')을 출력하는 기능

## Controller
### PrepareRaceController
- [x] makeCarNameArray: 입력받은 문자열을 구분자로 분리하여 문자열 배열에 저장하는 기능
- [x] makeCarList: 문자열 배열로 분리한 자동차 이름들을 리스트에 저장하는 기능
- [x] changeStringtoNumber: 문자열 형태로 입력받은 이동 시도 횟수를 숫자 형태로 변환하는 기능

### RacingController
- [x] getRandomNumber: 무작위수를 뽑는 기능
- [x] 자동차들의 이동 횟수 중 최댓값을 반환하는 기능
- [x] 이동 횟수의 최댓값과 같은 값을 가진 자동차를 찾는 기능

### Validator
- [x] checkCarNameisEmpty: 분리한 문자열 중 빈 문자열이 있는지 검사하는 기능
- [x] checkCarNameLengthMorethan5: 5글자 이상인 자동차 이름이 있는지 검사하는 기능
- [x] checkCarNameArraySizeMorethan5: 자동차 이름 개수가 5개를 초과하는지 검사하는 기능
- [x] checkAttemptsCountisNotNumber: 문자열 형태로 입력받은 이동 시도 횟수가 숫자가 아닌지 검사하는 기능
- [x] checkAttemptsCountisLessthan1: 숫자로 변환한 이동 시도 횟수가 1 미만인지 검사하는 기능
- [x] checkAttemptsCountisMorethan10: 이동 횟수가 10을 초과하는지 검사하는 기능
- [x] checkCarMoveable: 뽑은 무작위수가 이동 조건을 만족하는지 검사하는 기능