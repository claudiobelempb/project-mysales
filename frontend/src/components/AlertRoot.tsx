import { ComponentProps } from 'react';

export type Alert = {
  message?: string;
  field?: string;
  show?: boolean;
  type?: 'danger' | 'info' | 'success';
};

type AlertProps = {
  message?: string;
  field?: string;
  error?: boolean;
  type?: 'danger' | 'info' | 'success' | 'default';
} & ComponentProps<'div'>;

export const AlertRoot: React.FC<AlertProps> = ({ ...props }) => {
  {
    switch (props.type) {
      case 'danger':
        return (
          props.error && (
            <div className='border-l-4 border-red-700 px-2 py-1 bg-red-100 rounded-sm mb-2'>
              <p
                {...props}
                className={`font-medium space-y-2 text-sm text-red-700 dark:text-red-500 ${props.className}`}
              >
                {props.field && `${props.field}: `} {props.message}
              </p>
            </div>
          )
        );
      case 'info':
        return (
          props.error && (
            <div className='border-l-4 border-blue-700 px-2 py-1 bg-blue-100 rounded-sm mb-2'>
              <p
                {...props}
                className={`font-medium space-y-2 text-sm text-blue-700 dark:text-blue-500 ${props.className}`}
              >
                {props.field && `${props.field}: `} {props.message}
              </p>
            </div>
          )
        );
      case 'success':
        return (
          props.error && (
            <div className='border-l-4 border-green-700 px-2 py-1 bg-green-100 rounded-sm mb-2'>
              <p
                {...props}
                className={`font-medium space-y-2 text-sm text-green-700 dark:text-green-500 ${props.className}`}
              >
                {props.field && `${props.field}: `} {props.message}
              </p>
            </div>
          )
        );
      default:
        return (
          <div className='mb-1'>
            <p
              {...props}
              className={`font-medium space-y-2 text-sm text-gray-700 dark:text-gray-500 ${props.className}`}
            >
              {props.field && `${props.field}: `} {props.message}
            </p>
          </div>
        );
    }
  }
};
