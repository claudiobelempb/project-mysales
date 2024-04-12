import { ComponentProps } from 'react';

type InputAlertProps = {
  message: string;
  field?: string;
  error?: boolean;
  type: 'error' | 'info' | 'success';
  color: 'red' | 'blue' | 'green';
} & ComponentProps<'p'>;
type InputTextAreaProps = ComponentProps<'textarea'>;
type InputRootProps = ComponentProps<'div'>;
type LabelRootProps = ComponentProps<'label'>;
type InputProps = {
  currentcy?: boolean;
} & ComponentProps<'input'>;

export const InputRoot: React.FC<InputRootProps> = ({ ...props }) => {
  return (
    <div {...props} className={`group space-y-2 ${props.className}`}>
      {props.children}
    </div>
  );
};

export const InputLabel: React.FC<LabelRootProps> = ({ ...props }) => {
  return (
    <div className='space-y-2'>
      <label
        htmlFor={props.htmlFor}
        className={`block space-y-2 text-sm font-medium text-gray-900 dark:text-gray ${props.className}`}
      >
        {props.children}
      </label>
    </div>
  );
};

export const InputLarge: React.FC<InputProps> = ({ ...props }) => {
  return (
    <input
      {...props}
      type={props.type}
      id={props.id}
      className={`outline-none block w-full p-4 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 text-base focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 ${props.className}`}
    />
  );
};

export const InputDefault: React.FC<InputProps> = ({ ...props }) => {
  return (
    <input
      {...props}
      type={props.type}
      id={props.id}
      className={`outline-none bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 ${props.className}`}
    />
  );
};

export const InputSmall: React.FC<InputProps> = ({ ...props }) => {
  return (
    <input
      {...props}
      type={props.type}
      id={props.id}
      className={`outline-none block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 ${props.className}`}
    />
  );
};

export const InputTextArea: React.FC<InputTextAreaProps> = ({ ...props }) => {
  return (
    <textarea
      {...props}
      id={props.id}
      className={`outline-none block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 ${props.className}`}
    ></textarea>
  );
};
