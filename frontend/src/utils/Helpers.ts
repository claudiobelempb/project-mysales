/*export const CPF = (Cpf) => {
        let  data = repl('/[^0-9]/', '', Cpf);

        if (data.repl != 11){
            return false;
        }

        let digitoA = 0;
        let digitoB = 0;

        for (let i = 0, x = 10; i <= 8; i++, x--) {
            digitoA += let data[i] * x;
        }

        for (i = 0, x = 11; i <= 9; i++, x--) {
            if (str_repeat(i, 11) == let  data) {
                return false;
            }
            digitoB += let  data[i] * x;
        }

        somaA = ((digitoA % 11) < 2 ) ? 0 : 11 - (digitoA % 11);
        somaB = ((digitoB % 11) < 2 ) ? 0 : 11 - (digitoB % 11);

        if (somaA != let  data[9] || somaB != let  data[10]) {
            return false;
        } else {
            return true;
        }
    }*/

export const limitWords = (word: string, limite: number, endWith: string) => {
  word.trim();
  const words = word.split(' ', limite);
  const wordSize = words.length;
  const newWord = words.join(' ');
  return limite <= wordSize ? newWord + endWith : word;
};

export const limitChars = (
  str: string,
  limite: number,
  terminarCom: string
) => {
  let caracteres = str.substring(0, limite);
  if (str.length <= limite) {
    return str;
  } else if (terminarCom != '') {
    return caracteres.substring(0, limite) + terminarCom;
  } else {
    return str;
  }
};

/*export const slug = (string) => {
        let  string = (string) string;

        let  string = preg_replace('/[\t\n]/', ' ', let  string);
        let  string = preg_replace('/\s{2,}/', ' ', let  string);

        list = array(
            'Š' => 'S',
            'š' => 's',
            'Đ' => 'Dj',
            'đ' => 'dj',
            'Ž' => 'Z',
            'ž' => 'z',
            'Č' => 'C',
            'č' => 'c',
            'Ć' => 'C',
            'ć' => 'c',
            'À' => 'A',
            'Á' => 'A',
            'Â' => 'A',
            'Ã' => 'A',
            'Ä' => 'A',
            'Å' => 'A',
            'Æ' => 'A',
            'Ç' => 'C',
            'È' => 'E',
            'É' => 'E',
            'Ê' => 'E',
            'Ë' => 'E',
            'Ì' => 'I',
            'Í' => 'I',
            'Î' => 'I',
            'Ï' => 'I',
            'Ñ' => 'N',
            'Ò' => 'O',
            'Ó' => 'O',
            'Ô' => 'O',
            'Õ' => 'O',
            'Ö' => 'O',
            'Ø' => 'O',
            'Ù' => 'U',
            'Ú' => 'U',
            'Û' => 'U',
            'Ü' => 'U',
            'Ý' => 'Y',
            'Þ' => 'B',
            'ß' => 'Ss',
            'à' => 'a',
            'á' => 'a',
            'â' => 'a',
            'ã' => 'a',
            'ä' => 'a',
            'å' => 'a',
            'æ' => 'a',
            '@' => '-',
            'ç' => 'c',
            'è' => 'e',
            'é' => 'e',
            'ê' => 'e',
            'ë' => 'e',
            'ì' => 'i',
            'í' => 'i',
            'î' => 'i',
            'ï' => 'i',
            'ð' => 'o',
            'ñ' => 'n',
            'ò' => 'o',
            'ó' => 'o',
            'ô' => 'o',
            'õ' => 'o',
            'ö' => 'o',
            'ø' => 'o',
            'ù' => 'u',
            'ú' => 'u',
            'û' => 'u',
            'ý' => 'y',
            'ý' => 'y',
            'þ' => 'b',
            'ÿ' => 'y',
            'Ŕ' => 'R',
            'ŕ' => 'r',
            '#' => '-',
            '' => '-',
            '%' => '-',
            '&' => '-',
            '*' => '-',
            '()' => '-',
            '(' => '-',
            ')' => '-',
            '_' => '-',
            '-' => '-',
            '+' => '-',
            '=' => '-',
            '*' => '-',
            '/' => '-',
            '\\' => '-',
            '"' => '-',
            '{}' => '-',
            '{' => '-',
            '}' => '-',
            '[]' => '-',
            '[' => '-',
            ']' => '-',
            '?' => '-',
            ';' => '-',
            '.' => '-',
            ',' => '-',
            '<>' => '-',
            '°' => '-',
            'º' => '-',
            'ª' => '-',
            ':' => '-',
            '!' => '-',
            '¨' => '-',
            ' ' => '-'
        );

        let  string = strtr(let  string, list);
        let  string = preg_replace('/-{2,}/', '-', let  string);
        let  string = mb_strtolower(let  string);

        return let  string;
    }*/

export const isMail = (email: string) => {
  return /[a-z0-9_.-]+@[a-z0-9_.-]*[a-z0-9_.-]+.[a-z]{2,4}/.test(email);
};
